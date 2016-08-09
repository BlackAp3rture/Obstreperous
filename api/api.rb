require 'rubygems'
require 'sinatra'
require 'dm-core'
require 'dm-timestamps'
require 'dm-migrations'
require 'dm-serializer/to_json'
require 'bcrypt'


before do

  if !(request.path_info.include?("android"))
      elsif !(request.path_info.include?("home"))
      elsif !(request.path_info.include?("web"))
      elsif !(request.path_info.include?("ios"))
	  headers "Content-Type" => "application/json; charset=utf-8"	
	end
  
  
end




# load all libraries
configure do
  $LOAD_PATH.unshift("#{File.dirname(__FILE__)}/controller")
  Dir.glob("#{File.dirname(__FILE__)}/controller/*.rb") { |con| 
    require File.basename(con, '.*') 
  }
end

DataMapper.auto_upgrade!

