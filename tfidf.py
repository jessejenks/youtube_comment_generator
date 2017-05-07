import math
import re
# import csv

prepend = "comments_parsed/"

filename1 = prepend+"AlexJones.txt"
filename2 = prepend+"KidsReact.txt"
filename3 = prepend+"LiveToWin.txt"
filename4 = prepend+"PinkGuy.txt"
filename5 = prepend+"PorcupineEatsPumpkin.txt"
filename6 = prepend+"ScreamingGoats.txt"
filename7 = prepend+"TryGuys.txt"
filename8 = prepend+"VapeNaysh.txt"

output_file = "tfidf_scores.txt"

file_list = [
		filename1,
		filename2,
		filename3,
		filename4,
		filename5,
		filename6,
		filename7,
		filename8
	]

dict_list = []

for i in range(len(file_list)):
	terms_i = {}
	dict_list.append(terms_i)

howManyDocuments = {}

tf = []#[dict() for x in range(len(file_list))]

idf = []#[dict() for x in range(len(file_list))]

tfidf = []#[dict() for x in range(len(file_list))]

def doTheThing(filenames, dictionaries):
	for i in xrange(len(filenames)):
		with open(filenames[i]) as my_file:
			for line in my_file:
				# split_test = 
				words = re.split('[,.!?" \-\\n]', line.lower())
				# words = line.lower().split()
				# print [word for word in split_test if word in words]
				for word in words:
					if word in dictionaries[i]:
						dictionaries[i][word] += 1
					else:
						dictionaries[i][word] = 1

def doTheOtherThing(terms_list):
	for terms in terms_list:
		for term in terms:
			if term in howManyDocuments:
				howManyDocuments[term] += 1
				continue
			else:
				howManyDocuments[term] = 1
				continue

def termFrequency(terms_list):
	for terms in terms_list:
	# for i in range(len(terms_list)):
		# terms = terms_list[i]
		# tf[i] = {}
		temp_dict = {}
		for term in terms:
			temp_dict[term] = float(terms[term])/len(terms)
		tf.append(temp_dict)

def inverseDocumentFrequency(terms_list):
	for terms in terms_list:
	# for i in range(len(terms_list)):
		# terms = terms_list[i]
		# idf[i] = {}
		temp_dict = {}
		for term in terms:
			temp_dict[term] = math.log(float(len(terms_list))/howManyDocuments[term])
		idf.append(temp_dict)

def termFreqIDF(terms_list):
	# for terms in terms_list:
	for i in range(len(terms_list)):
		terms = terms_list[i]
		# tfidf[i] = {}
		temp_dict = {}
		for term in terms:
			temp_dict[term] = tf[i][term]*idf[i][term]
		tfidf.append(temp_dict)

doTheThing(file_list, dict_list)
doTheOtherThing(dict_list)

termFrequency(dict_list)

inverseDocumentFrequency(dict_list)

termFreqIDF(dict_list)

print '\ntfidf scores\n\n'

for i in range(len(tfidf)):
	tfidf_sorted = [(v,k) for k,v in tfidf[i].iteritems()]
	tfidf_sorted.sort(reverse=True)
	output = open(str(i+1)+"_"+output_file, 'w')
	# with open(output_file, 'wb') as csv_file:
	for k,v in tfidf_sorted:
		# print v.split()
		output.write(v+", "+str(k))
		output.write("\n")
		# if k > 0.01:
			# print v," : ",k

	output.close()