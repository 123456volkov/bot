import telebot
import misc

bot = telebot.TeleBot(misc.token);

@bot.message_handler(commands=['start', 'help'])
def send_welcome(message):
	bot.reply_to(message, "Hey, I'm your english teacher")
	
bot.polling()