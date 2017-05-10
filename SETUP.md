# SETUP FOR LAB COMPUTERS

## ANACONDA



First go to:
[the anaconda site](https://www.continuum.io/downloads)

download for 2.7
put the

`Anaconda2-4.3.1-Linux-x86_64.sh`

file inside the folder from git, lets say you called it `FOLDER`

in terminal `cd` into `FOLDER`

```sh
~ $ cd FOLDER
```
run 

```sh
~/FOLDER $ bash Anaconda2-4.3.1-Linux-x86_64.sh
```

lots of things get installed just hit enter, yes, or y for everything
now run

```sh
~/FOLDER $ conda create -n tensorflow
```
```sh
~/FOLDER $ source activate tensorflow
```

terminal should now look like

```sh
(tensorflow) mbogert@Th420-n ~/FOLDER $ 
```



## TENSORFLOW
now run
```sh
$ pip install --ignore-installed --upgrade https://storage.googleapis.com/tensorflow/linux/cpu/tensorflow-1.1.0-cp27-none-linux_x86_64.whl
```

a bunch of stuff should get installed


## KERAS
now run
```sh
(tensorflow) ... ~/FOLDER $ pip install keras
```


some more stuff should get installed


## TRAINING
create a folder called `WEIGHTS_GO_HERE` in the git `FOLDER`

open up `train.py` in sublime and there should be a big comment near the top where you should change the file path

## FINALLY
run 
```sh
(tensorflow) ... ~/FOLDER $ python train.py
```

and you should see a progress bar!!

### sidenote
If you want to start generating, open up `generate.py`, change the file path near the top.
open up the `WEIGHTS_GO_HERE` folder and copy and paste the name of the `.hdf5` file with the lowest weight or latest epoch number. It's set to only save improving weights, so these should be the same thing.
Change the file path at the bottom of `generate.py` to the path to this file
now run
```sh
(tensorflow) ... ~/FOLDER $ python train.py
```
to see some generated text!