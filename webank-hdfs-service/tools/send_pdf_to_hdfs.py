import requests
import sys


def delete_all():
    params = (
        ('user.name', 'hdfs'),
        ('op', 'DELETE'),
    )

    for i in range(1, 12):
        response = requests.delete('http://webank-hdfs1.webank.inside.esiag.info:50070/webhdfs/v1/bas/bas_{}.pdf'.format(str(i)), params=params)
        print(response.text)

def create_all():
    params = (
        ('user.name', 'hdfs'),
        ('op', 'CREATE'),
    )

    for i in range(1, 12):
        files = {'file': open('bas_{}.pdf'.format(i), 'rb')}
        response = requests.put('http://webank-hdfs1.webank.inside.esiag.info:50070/webhdfs/v1/bas/bas_{}.pdf'.format(str(i)), params=params, files=files)
        print(response.status_code)


if __name__ == '__main__':

    if sys.argv[1] == "d":
        delete_all()
    else:
        create_all()