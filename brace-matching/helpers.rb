BRACES = {
  '{' => '}',
  '(' => ')',
  '<' => '>',
  '[' => ']'
}

def closing(c)
  BRACES[c]
end

def start?(c)
  !closing(c).nil?
end

POSITIVE_EXAMPLES = [
  '',
  '[]',
  '[][]',
  '[()<>]'
]

NEGATIVE_EXAMPLES = [
  ']',
  '[',
  '[][]]',
  '[()<]'
]
