Tilt.register Tilt::ERBTemplate, 'html.erb'


helpers do

  def partial(template)
    erb template, :layout => true
  end



    get '/home' do
        erb :index
    end

    get '/ios' do
        #erb :ios
       erb 'Coming Soon'
    end

    get '/android' do
        erb :android
    end

    get '/web' do
        erb :web
        #erb 'Coming Soon'
    end

end






get '/ios/datastorage' do
    erb 'ios/datastorage'.to_sym
end

get '/ios/Authentication' do
    erb 'ios/Authentication'.to_sym
end

get '/ios/Cryptography' do
    erb 'ios/Cryptography'.to_sym
end

get '/ios/Intents' do
    erb 'ios/Intents'.to_sym
end





get '/web/Authentication' do
    erb 'web/Authentication'.to_sym
end

get '/web/SessionHandling' do
    erb 'web/SessionHandling'.to_sym
end

get '/web/XSS' do
    erb 'web/XSS'.to_sym
end

get '/web/CSRF' do
    erb 'web/CSRF'.to_sym
end

get '/web/sqlinjection' do
    erb 'web/sqlinjection'.to_sym
end

get '/web/traversals' do
    erb 'web/traversals'.to_sym
end

get '/web/fileinclusion' do
    erb 'web/fileinclusion'.to_sym
end









get '/android/datastorage' do
   erb 'android/datastorage'.to_sym
end

get '/android/Authentication' do
   erb 'android/Authentication'.to_sym
end

get '/android/Cryptography' do
   erb 'android/Cryptography'.to_sym
end

get '/android/Intents' do
   erb 'android/Intents'.to_sym
end

get '/android/ActivityBypassing' do
   erb 'android/ActivityBypassing'.to_sym
end

get '/android/ServiceBypassing' do
   erb 'android/ServiceBypassing'.to_sym
end

get '/android/URLSchemes' do
   erb 'android/URLSchemes'.to_sym
end

get '/android/BinaryProtections' do
   erb 'android/BinaryProtections'.to_sym
end

get '/android/m9' do
   erb 'android/m9'.to_sym
end

get '/android/m10' do
   erb 'android/m10'.to_sym
end
