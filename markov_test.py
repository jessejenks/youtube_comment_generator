import markovify

filename = "MY_FILE"

with open(filename) as data:
	test = data.read()
	text_model = markovify.Text(test)
	print(text_model.make_short_sentence(140))