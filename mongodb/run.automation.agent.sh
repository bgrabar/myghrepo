#!/bin/bash

# run Automation Agent for local install of Cloud Manager


nohup /opt/mongodb-mms-automation-agent --config=local.config >> /var/log/mongodb-mms-automation/automation-agent.log 2>&1 &