document = input('')
word = input('')

cnt = 0
song = 0

while song <= len(document) - len(word):
    if document[song:song + len(word)] == word:
        cnt += 1
        song += len(word)
    else:
        song += 1
print(cnt)