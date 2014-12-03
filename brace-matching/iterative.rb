require_relative 'helpers'

def match_it(s)
  closings = []
  s.chars.each do |c|
    if start? c
      closings << closing(c)
    else
      return false unless closings.pop == c
    end
  end
  closings.empty?
end

['',
 '[]',
 '[][]',
 '[()<>]'].each do |s|
   puts "true => #{match_it s}"
 end

[']',
 '[',
 '[][]]',
 '[()<]'].each do |s|
   puts "false => #{match_it s}"
 end
