'''
Created on 29 jul. 2020

@author: juanluis
'''

from bs4 import BeautifulSoup
import json
import requests


def main():
    lista = capture()
    save_json(lista)
            
def capture():
    url = 'https://www.profesordeingles.eu/verbos-irregulares-en-ingles/lista-verbos-irregulares-en-ingles.php'
    print('Trying to connect to ' + url + '...')
    # Realizamos la petición a la web
    req = requests.get(url, timeout = 10)
    # Comprobamos que la petición nos devuelve un Status Code = 200
    status_code = req.status_code
    if status_code == 200:
        print('Connection sucessfull!')
        # Pasamos el contenido HTML de la web a un objeto BeautifulSoup()
        soup = BeautifulSoup(req.text, "html.parser")
        # Obtenemos tipo de clasificación
        filas = soup.find_all('tr', attrs = {'class': 'gradeA'})
        lis = list()
        for fila in filas:
            dic = dict()
            verbos = fila.find_all('td')
            dic['infinitive'] = verbos[0].getText()
            dic['past'] = verbos[1].getText()
            dic['participle'] = verbos[2].getText()
            dic['translate'] = verbos[3].getText()
            lis.append(dic)
    return lis

def save_json( _lis ):
        # write file
        with open("irregular_verbs.json", "w") as f:
            json.dump(_lis, f, indent = 4)
                
if __name__ == '__main__':
    main()