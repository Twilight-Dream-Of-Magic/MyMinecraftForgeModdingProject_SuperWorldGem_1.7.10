from http.server import HTTPServer, BaseHTTPRequestHandler
import reque

class SimpleHTTPRequestHandler(BaseHTTPRequestHandler):
	def do_HEAD(self):
		self.send_response(200)
		self.end_headers()

		request_url = "http://insecure.repo1.maven.org" + self.path
		print("Requesting HEAD @ " + request_url)

		try:
			self.wfile.write(requests.head(request_url).content)
		except Exception as e:
			print("Caught " + str(e) + "!")
			print()
			print()

	def do_GET(self):
		self.send_response(200)
		self.end_headers()

		request_url = "http://insecure.repo1.maven.org" + self.path
		print("Requesting GET @ " + request_url)

		try:
			self.wfile.write(requests.get(request_url).content)
		except Exception as e:
			print("Caught " + str(e) + "!")
			print()
			print()

httpd = HTTPServer(('localhost', 80), SimpleHTTPRequestHandler)
httpd.serve_forever()