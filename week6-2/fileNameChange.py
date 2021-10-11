import os
from glob import glob

os.chdir("C:\\Users\\leeye\\Desktop\\과제\\스마트앱프로그래밍\\PNG-cards-1.3")
[os.rename(f,"{}{}".format("c_",f)) for f in glob("*.png")]
