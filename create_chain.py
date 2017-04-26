import random
import pickle

# use .txt files
file1 = "FILE_1" # "seinfeld.txt"
file2 = "FILE_2"
file3 = "FILE_3"

beginToken = "BEGIN"
endToken = "END"

chain = {}
beginnings = []

# n-th order markov assumptions

# order must be >= 1
def makeNGram(data, order):
	n = order + 1
	if n >= 2 and len(data) >= n:
		beginnings.append(data[n-1])
		for i in xrange(len(data) - (n-1)):
			out = tuple()
			for j in xrange(n):
				out = out[:] + (data[i+j],)
			yield out

# order is order of markov assumtion
def addToChain(filename, order):
	with open(filename) as data:
		for line in data:
			sentence = line.split()
			for i in xrange(order):
				sentence.insert(0, beginToken+str(order-i))
			sentence.append(endToken)
			for n_gram in makeNGram(sentence, order):
				key = n_gram[:-1]
				if key in chain:
					chain[key].append(n_gram[-1])
				else:
					chain[key] = [n_gram[-1]]

# standard chain from one file to one chain
def createChain(filename, output_name, order):
	addToChainOne(filename, order)
	myOutputChain = (order, beginnings, chain)
	pickle.dump(myOutputChain, open(output_name+".p", "wb"))
	chain = {}
	beginnings = []

# making multiple markov chains for multiple files
# the number is the order
createChain(file1, "my_first_chain", 2)
createChain(file2, "my_second_chain", 1)

# make a combined markov chain from different sources
addToChain(file1,2)
addToChain(file2,2)
addToChain(file3,2)
myOutputChain = (2, beginnings, chain)
pickle.dump(myOutputChain, open("my_combined_chain.p", "wb"))