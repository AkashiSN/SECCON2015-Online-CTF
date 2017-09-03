from glob import glob
import os

path = "*.jpg"
file = " ".join(glob(path))
command = "convert {} -background none -compose lighten -flatten output.jpg".format(file)

print(command)
os.system(command)