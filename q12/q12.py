import hpack

decoder = hpack.Decoder()
data = decoder.decode("88c3c24085f2b4b40e6f94dd82f5ed5a7fff63ff7feeb119b46a200fff3ffd0f0d023137c1c0bf4089f2b4e94d625abb513f0131".decode('hex'))

print data