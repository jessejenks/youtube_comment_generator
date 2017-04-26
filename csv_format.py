import csv

filename = "MY_FILE.csv"
output_file = "MY_FILE.txt"

output = open(output_file, 'w')
with open(filename, 'rb') as csvfile:
	reader = csv.reader(csvfile, delimiter=',')
	for row in reader:
		# or whatever column the comments are on
		line = row[4]
		if not (line == '' or line == 'commentText'):
			output.write(line)
			output.write("\n")
output.close()