# SETUP FOR LAB COMPUTERS

## ANACONDA



First go to:
[](https://www.continuum.io/downloads)

download for 2.7
put the 
> Anaconda2-4.3.1-Linux-x86_64.sh
file inside the folder from git

in terminal cd into folder
> ~ $ cd FOLDER
run 
> ~/FOLDER $ bash Anaconda2-4.3.1-Linux-x86_64.sh

lots of things get installed just hit enter, yes, or y for everything
now run

> ~/FOLDER $ conda create -n tensorflow
> ~/FOLDER $ source activate tensorflow

terminal should now look like
	(tensorflow) mbogert@Th420-n ~/FOLDER $



## TENSORFLOW
now run
> (tensorflow) ... ~/FOLDER $ pip install --ignore-installed --upgrade https://storage.googleapis.com/tensorflow/linux/cpu/tensorflow-1.1.0-cp27-none-linux_x86_64.whl

a bunch of stuff should get installed



## KERAS
now run
> (tensorflow) ... ~/FOLDER $ pip install keras

some more stuff should get installed



## TRAINING
create a folder called
> WEIGHTS_GO_HERE
in the git FOLDER

open up train.py and generate.py
there should be a big comment near the top where you should change the file path

## FINALLY
run 
> (tensorflow) ... ~/FOLDER $ python train.py

and you should see a progress bar!!