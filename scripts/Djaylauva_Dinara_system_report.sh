#!/bin/bash
# System report by Dinara Djaylauva (ID 38086)
LOG="$(dirname "$0")/../logs/Djaylauva_Dinara_system_report.log"
{
echo "Student: Dinara Djaylauva (ID 38086)"
echo "Date: $(date)"
echo "User: $(whoami)"
echo "OS: $(grep PRETTY_NAME /etc/os-release | cut -d'"' -f2)"
echo "Kernel: $(uname -r)"
echo "--- CPU ---"; lscpu | grep -E "Model name|^CPU\(s\)"
echo "--- Memory ---"; free -h
echo "--- Disk usage ---"; df -h
echo "--- Available space on / ---"; df -h / | awk 'NR==2{print $4}'
} | tee -a "$LOG"
