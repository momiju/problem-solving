def solution(babbling):
    answer = 0
    
    for word in babbling:
        for sound in ["aya", "ye", "woo", "ma"]:
            word = word.replace(sound, " ")
        if word.replace(" ", "") == "":
            answer+=1
    
    return answer