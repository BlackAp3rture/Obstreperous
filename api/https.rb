# encoding: UTF-8
require 'webrick'
require 'webrick/https'
include WEBrick


root = File.expand_path './public'

cert = OpenSSL::X509::Certificate.new File.read 'cert.crt'
pkey = OpenSSL::PKey::RSA.new File.read 'pkey.pem'



server = HTTPServer.new(
  :Port => '4430',
  :DocumentRoot => root,
  :SSLEnable => true,
  :SSLCertificate => cert,
  :SSLPrivateKey => pkey)

server.mount_proc '/' do |req, res|
    req.attributes['body'] = req.body
    
    if req.body == 'username=test&password=test'
    	res.body = 'OK'
    	end
end

trap('INT') { server.shutdown }

server.start