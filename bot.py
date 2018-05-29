import requests
import misc
from yobit import get_btc

token = misc.token

URL = 'https://api.telegram.org/bot' + token + '/'

global last_update_id
last_update_id = 0

def get_updates():
    url = URL + 'getupdates'
    responce = requests.get(url)
    return responce.json()

def get_message():
    data = get_updates()

    last_object = data['result'][-1]
    curent_update_id = last_object['update_id']
    global last_update_id

    if last_update_id != curent_update_id:
        last_update_id = curent_update_id
        chat_id = data['result'][-1]['message']['chat']['id']
        message_text = data['result'][-1]['message']['text']
        message = {'chat_id': chat_id,
                  'text': message_text}
        return message

    return None

def send_message(chat_id, text = 'Привет!'):
    url = URL + 'sendmessage?chat_id={}&text={}'.format(chat_id, text)
    requests.get(url)

def main():
    while True:
        answer = get_message()
        if answer != None:
            if answer['text'] == '/btc':
                send_message(answer['chat_id'], get_btc())
        else:
            continue
if __name__ == '__main__':
    main()
