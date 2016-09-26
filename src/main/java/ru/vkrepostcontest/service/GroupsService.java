package ru.vkrepostcontest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ru.vkrepostcontest.service.authentication.AccessToken;

/**
 * @author Roman
 * @since 0.1
 */
@Service
public class GroupsService {

    @Autowired
    private AccessToken accessToken;

    @Autowired
    private RestTemplate restTemplate;

}
