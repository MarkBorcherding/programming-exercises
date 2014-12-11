def qs(l)
  return [] if l == []
  head = qs(l[1..-1].reject { |i| i >= l[0] })
  split = [l[0]]
  tail = qs(l[1..-1].reject { |i| i < l[0] })
  head + split + tail
end

puts qs([1, 2, 3, 4, 5, 6]).inspect
puts qs([6, 4, 5, 2, 1, 3]).inspect
