# Get a list of files.
# Rename the list of files.


import os            # for os.getcwd, os.listdir, os.chdir, os.rename

def rename_files():

  working_path = os.getcwd()

  print working_path
  # print working_path

  new_path = "/Users/bob/myrepo/udacity_course_36/lesson_1/prank"
  # print new_path

  file_list = os.listdir(new_path)
  # print file_list

  os.chdir(new_path)
  for file_name in file_list:
    print("Old Name - "+file_name)
    os.rename(file_name, file_name.translate(None, "0123456789"))
    print("New Name - "+file_name.translate(None, "0123456789"))

  os.chdir(working_path)


rename_files()


