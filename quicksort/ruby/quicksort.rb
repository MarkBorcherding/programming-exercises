def qs(l)
  if l == []
    []
  else
    pivot, *tail = l
    qs(tail.reject { |i| i >= pivot }) +
      [pivot] +
      qs(tail.reject { |i| i < pivot })
  end
end

puts qs([1, 2, 3, 4, 5, 6]).inspect
puts qs([6, 4, 5, 2, 1, 3]).inspect
puts qs([6, 4, 5, 7, 5, 2, 1, 3]).inspect
