from selenium import webdriver

driver = webdriver.Chrome('/Users/bonkim/Downloads/chromedriver')
driver.implicitly_wait(2)
driver.get('https://comic.naver.com/notice/list')
mail_content = ""
content = #content > table > tbody > tr:nth-child(13) > td:nth-child(1) > a > span
if (content.inside('유료화 전환 작품 안내'))
	content.click()
	names[] = #content > div.notice_detail > div.info_detail
	for name in names:
		mail_content += name


stmp.send(mail_content)

#stmp 서버 / 셀레늄 / selenuim은 copy selevtor로 정보 가져오기 copy -> copy
