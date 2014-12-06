DENOMINATIONS = [1, 5, 10, 25].sort.reverse

def make_change(amount, denominations)
  return {} if denominations.empty?
  d = denominations[0]
  Hash[d, amount / d]
    .merge(make_change(amount % d, denominations[1..-1]))
end

puts make_change(2, DENOMINATIONS)
puts make_change(20, DENOMINATIONS)
puts make_change(27, DENOMINATIONS)
