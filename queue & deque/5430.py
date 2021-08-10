import sys
# https://chancoding.tistory.com/41 를 참고함
def AC(comm, arraylen, array):
    left, right, reverse = 0, 0, False
    for c in comm:
        if c == 'R': reverse = not reverse
        elif c == 'D':
            if reverse: right += 1
            else: left += 1
    if(left + right <= arraylen):
        result = array[left:arraylen - right]
        if not reverse: return '[' + ','.join(result) + ']\n'
        else: return '[' + ','.join(result[::-1]) + ']\n'
    else:
        return "error\n"

t = int(sys.stdin.readline())
for i in range(t):
    command = sys.stdin.readline().replace("RR", "")
    arraylen = int(sys.stdin.readline())
    array = sys.stdin.readline().rstrip()[1:-1].split(",")
    if arraylen == 0 : []
    sys.stdout.write(AC(command, arraylen, array))