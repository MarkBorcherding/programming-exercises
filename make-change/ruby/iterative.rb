DENOMINATIONS = [1, 5, 10, 25]

def make_change(amount)
  change = {}
  DENOMINATIONS.sort.reverse.each do |d|
    change[d] = amount / d
    amount = amount % d
  end
  change
end

puts make_change(2)
puts make_change(20)
puts make_change(27)
puts make_change(56)
