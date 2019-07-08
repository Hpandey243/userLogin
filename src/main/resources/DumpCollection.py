# -*- coding: utf-8 -*-
"""
Created on Mon Jun 10 20:28:07 2019

@author: Himanshu
"""

from pymongo import MongoClient
import json
client = MongoClient("localhost:27017")
db=client.userDatabase
''' connected to db '''

coll=db.user
''' into the collection user '''

for x in coll.find():
    print(x)
    ''' gives data  '''

cursor = coll.find({})

file = open("collection.json", "w")
file.write('[')
''' to form json array '''
for document in cursor:
    file.write(json.dumps(document))
    file.write(',')
file.write(']')
file.close()

'''creates and succesfully saves the collection data as json array'''
