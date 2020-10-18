#!/bin/bash

sudo docker run jenkins/inbound-agent -url http://172.17.0.1:8080/jenkins -workDir=/home/jenkins/agent 430fa1da020e7fca4344d120cfc70f7f1baf9202a6b635a71c1c0f85b617b0d4 mynode
