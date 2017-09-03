#!/usr/bin/env python3
with open('no-network.txt') as f:
    text = f.read()

text = ''.join(text.split('\n'))

nonets = []
for i in range(len(text) // 3):
    nonets.append(int(text[i * 3:i * 3 + 3], 8))

i = 0
result = b'\xfe\xff'#utf-16be bom
while i < len(nonets):
    if (nonets[i] & 0x100) == 0:
        result += b'\xff' + (nonets[i] & 0xff).to_bytes(1, byteorder='big')
    else:
        result += (nonets[i] & 0xff).to_bytes(1, byteorder='big') + (nonets[i+1]).to_bytes(1, byteorder='big')
        i += 1
    i += 1
    if i % 27 == 0:
        result += b'\x00\x0a'

with open('ans' ,'wb') as f:
    f.write(result)