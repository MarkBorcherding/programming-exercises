#
class Markov

  attr_accessor :map

  def initialize
    self.map = {}
  end

  def train(words)
    words.each_cons(2) do |pair|
      if pair[0] =~ /[\.\?!]$/
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
    words = []
    next_word =  map[:start].keys.sample
    while next_word != :end do
      words << next_word
      next_word =next_word(words.last)
    end
    words.join " "
  end

  def next_word(w)
    choices = map[w]
    count = choices[:count].to_f
    choices.reject{ |c| c == :count }.reduce(rand) do |left,v|
      left = left - (v[1]/count)
      return v[0] if left < 0
      left
    end
  end
end
