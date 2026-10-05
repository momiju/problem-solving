def solution(my_string, n):
    result = ""
    
    for word in my_string:
        result += word*n
    
    return result