package ru.vkrepostcontest.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import ru.vkrepostcontest.VkRestRequestService;
import ru.vkrepostcontest.convert.PostConverter;
import ru.vkrepostcontest.domain.WordFind;
import ru.vkrepostcontest.domain.WordFindType;
import ru.vkrepostcontest.responseForm.newsfeed.NewsfeedResponseForm;
import ru.vkrepostcontest.resstrequest.NewsfeedRestRequest;
import ru.vkrepostcontest.service.WordFindService;
import ru.vkrepostcontest.service.newsfeed.NewsfeedService;
import ru.vkrepostcontest.service.post.PostService;
import ru.vkrepostcontest.util.DateUtil;

/**
 * @author Stetskevich Roman on 08.09.2016.
 * @since 0.1
 */
@Component
@DependsOn("wordFindDbInit")
public class PostsFind {

	/**
	 * Максимальное кол
	 */
	private final int NUMBER_REQUESTS = VkRestRequestService.OFFSET /
			NewsfeedRestRequest.COUNT;

	/**
	 * одна минута
	 */
	private final long MINUTE = 1000 * 60;

	private org.slf4j.Logger logger = LoggerFactory.getLogger(PostsFind.class);

	@Autowired
	private NewsfeedService newsfeedService;

	@Autowired
	private PostService postService;

	@Autowired
	private WordFindService wordFindService;

	@Autowired
	private PostConverter postConverter;

	@PostConstruct
	public void init() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				Calendar calendar = Calendar.getInstance();
				Calendar finish = Calendar.getInstance();
				finish.setTime(new Date());
				//поиск в течении месяца
				finish.add(Calendar.MONTH, 1);
				List<WordFind> contests = wordFindService.findAllByType(WordFindType.CONTEST);
				List<WordFind> reposts = wordFindService.findAllByType(WordFindType.REPOST);
				//циклы по конкурсу и репосту
				contests.forEach(contest -> {
					reposts.forEach(repost -> {
						int numberPosts = 0;
						while (calendar.before(finish)) {
							String nextFrom = null;
							int num = 0;
							//4 по 200
							for (int i = 0; i < NUMBER_REQUESTS; i++) {
								NewsfeedResponseForm newPostsFromVK = newsfeedService.getNewPostsFromVK(createSearchString(contest, repost, calendar.getTime()), nextFrom);
								nextFrom = newPostsFromVK.getNextFrom();
								newPostsFromVK.getPosts().forEach(postResponseForm -> postService.savePost(postConverter.formToObject(postResponseForm)));
								numberPosts += newPostsFromVK
										.getPosts()
										.size();
								num += newPostsFromVK
										.getPosts()
										.size();
							}
							logger.info("Добавлено {} новых постов в базу данных " +
									"на " + DateUtil.getStringDate(calendar
									.getTime()) +
									".", num);
							//прибавить день
							calendar.add(Calendar.DAY_OF_YEAR, 1);
						}
						logger.info("Добавлено {} новых постов в базу данных " +
								"на ближайший месяц" +
								".", numberPosts);
					});
				});

			}
		}, 0, MINUTE);
	}

	/**
	 * создать строку для поиска "конкурс репост дата"
	 *
	 * @param contest
	 * @param repost
	 * @param date
	 * @return
	 */
	private String createSearchString(WordFind contest, WordFind repost, Date date) {
		return new StringBuilder().append(contest.getWord()).append(" ")
				.append(repost.getWord()).append(" ").append(DateUtil.getStringDate(date))
				.toString();
	}
}