import telebot
import misc
from googletrans import Translator

translator = Translator()
bot = telebot.TeleBot(misc.token)

@bot.message_handler(commands=['start', 'help'])
def send_welcome(message):
	bot.reply_to(message, "Hey, I'm your english teacher")
	
@bot.message_handler(commands=['en'])
def echo_all(message):
	bot.reply_to(message, (translator.translate(message.text.split('/en')[1] , dest='en')).text)
	
@bot.message_handler(func=lambda message: True)
def echo_all(message):
	bot.reply_to(message, (translator.translate(message.text, dest='ru')).text)

try:	
	bot.polling()
except socket.timeout:
	bot.polling()