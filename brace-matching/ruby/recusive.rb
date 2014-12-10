require_relative 'helpers'

def match_it(s, matches = [])
  return matches.empty?  if s.empty?
  head = s.shift
  if start? head
    match_it s, matches << closing(head)
  else
    (head == matches.pop) && match_it(s, matches)
  end
end

POSITIVE_EXAMPLES.each do |s|
  puts "true => #{match_it s.chars.to_a}"
end

NEGATIVE_EXAMPLES.each do |s|
  puts "false => #{match_it s.chars.to_a}"
end
