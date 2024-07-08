package com.vshumick.task.kyiv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class InstanceInfoController {

    @GetMapping("/instance-info")
    public String getInstanceInfo() {
        try {
            return "Instance ID: " + InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "Unable to get instance ID";
        }
    }
}
