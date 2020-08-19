'''
Created on 13 ago. 2020

@author: juanluis
'''
import unittest
from irregular_verbs_scraping import capture

class Test(unittest.TestCase):


    def testList(self):
        lista = capture()
        self.assertEqual(len(lista), 145)
        
        verbo = lista[0]
        self.assertEqual(verbo['infinitive'], 'arise')
        self.assertEqual(verbo['past'], 'arose')
        self.assertEqual(verbo['participle'], 'arisen')
        self.assertEqual(verbo['translate'], 'surgir')

        verbo = lista[49]
        self.assertEqual(verbo['infinitive'], 'go')
        self.assertEqual(verbo['past'], 'went')
        self.assertEqual(verbo['participle'], 'gone')
        self.assertEqual(verbo['translate'], 'irse')
        
        verbo = lista[50]
        self.assertEqual(verbo['infinitive'], 'grind')
        self.assertEqual(verbo['past'], 'ground')
        self.assertEqual(verbo['participle'], 'ground')
        self.assertEqual(verbo['translate'], 'moler')
        
        verbo = lista[144]
        self.assertEqual(verbo['infinitive'], 'write')
        self.assertEqual(verbo['past'], 'wrote')
        self.assertEqual(verbo['participle'], 'written')
        self.assertEqual(verbo['translate'], 'escribir')        

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testList']
    unittest.main()