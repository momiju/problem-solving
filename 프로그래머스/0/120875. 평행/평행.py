def solution(dots):
    def paralle(a,b):
        return (b[1]-a[1])/(b[0]-a[0])
    if paralle(dots[0], dots[1]) == paralle(dots[2], dots[3]):
        return 1
    if paralle(dots[0], dots[2]) == paralle(dots[1], dots[3]):
        return 1
    if paralle(dots[0], dots[3]) == paralle(dots[1], dots[2]):
        return 1
    
    return 0