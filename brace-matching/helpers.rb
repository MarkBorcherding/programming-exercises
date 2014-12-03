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
  !!closing(c)
end
