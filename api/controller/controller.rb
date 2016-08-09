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
        #erb :web
        erb 'Coming Soon'
    end

end






get '/ios/datastorage' do
    erb 'ios/datastorage'.to_sym
end

get '/ios/AuthenticationandAuthorization' do
    erb 'ios/AuthenticationandAuthorization'.to_sym
end

get '/ios/Cryptography' do
    erb 'ios/Cryptography'.to_sym
end

get '/ios/Intents' do
    erb 'ios/Intents'.to_sym
end





get '/web/datastorage' do
    erb 'web/datastorage'.to_sym
end

get '/web/AuthenticationandAuthorization' do
    erb 'web/AuthenticationandAuthorization'.to_sym
end

get '/web/Cryptography' do
    erb 'web/Cryptography'.to_sym
end

get '/web/Intents' do
    erb 'web/Intents'.to_sym
end

get '/web/datastorage' do
    erb 'web/datastorage'.to_sym
end

get '/web/AuthenticationandAuthorization' do
    erb 'web/AuthenticationandAuthorization'.to_sym
end

get '/web/Cryptography' do
    erb 'web/Cryptography'.to_sym
end

get '/web/Intents' do
    erb 'android/Intents'.to_sym
end













get '/android/datastorage' do
   erb 'android/datastorage'.to_sym
end

get '/android/AuthenticationandAuthorization' do
   erb 'android/AuthenticationandAuthorization'.to_sym
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
