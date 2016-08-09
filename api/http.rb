require 'webrick'

root = File.expand_path './public'
server = WEBrick::HTTPServer.new :Port => 4431, :DocumentRoot => root


server.mount_proc '/' do |req, res|
    req.attributes['body'] = req.body
    
    if req.body == 'username=test&password=test'
    	res.body = 'OK'
    	end
end

trap('INT') { server.shutdown }

server.start