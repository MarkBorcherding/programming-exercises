require_relative 'helpers'

def match_it(s, matches = [])
  return matches.empty?  if s.empty?
  if start? s[0]
    matches << closing(s.shift)
    return match_it s, matches
  else
    return (s.shift == matches.pop) && match_it(s, matches)
  end
end

POSITIVE_EXAMPLES.each do |s|
  puts "true => #{match_it s.chars.to_a}"
end

NEGATIVE_EXAMPLES.each do |s|
  puts "false => #{match_it s.chars.to_a}"
end
