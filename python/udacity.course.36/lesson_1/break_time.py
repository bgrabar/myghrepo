import time
import webbrowser

total_breaks = 3
counter = 1

print("The time is " + time.ctime())

while(counter <= total_breaks):
  time.sleep(10)
  webbrowser.open("https://www.youtube.com/watch?v=dZn_VBgkPNY")
  counter = counter + 1
  print counter

print("The time is " + time.ctime())




