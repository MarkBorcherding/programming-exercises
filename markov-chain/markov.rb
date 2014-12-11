#
class Markov

  attr_accessor :map

  def initialize
    self.map = {}
  end

  def train(words)
    words.each_cons(2) do |pair|
      if pair[0].end_with? '.'
        transition pair[0], :end
        transition :start, pair[1]
      else
        transition *pair
      end
    end
  end

  def transition(from, to)
    map[from] ||= {}
    map[from][to] ||= 0
    map[from][to] += 1
    map[from][:count] ||= 0
    map[from][:count] += 1
  end

  def generate
    start = map[:start].keys.sample
    s = map[start]

  end
end
