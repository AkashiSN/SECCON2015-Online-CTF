#!/usr/bin/env python
from PIL import Image,ImageChops
from image4layer import Image4Layer
import io

data = open("MrFusion.gpjb","rb")

address = [9727,26632,2791486,2794240,2796217,2813627,5578481,5580896,5583378,5601221,8366075,8368830,8371932]

first = Image.open(io.BytesIO(data.read(6943)))
first.save("first.png")

source = Image.open(io.BytesIO(data.read(2784)))
source = source.convert('RGB')

for i in range(len(address)-1):
	image = Image.open(io.BytesIO(data.read(address[i+1]-address[i])))
	image = image.convert('RGB')
	source = ImageChops.lighter(source,image)

end = Image.open(io.BytesIO(data.read(16454)))
end.save("end.png")

source.save("out.png")