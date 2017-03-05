"""Write a HashTable class that stores strings
in a hash table, where keys are calculated
using the first two letters of the string."""

class HashTable(object):
    def __init__(self):
        self.table = [None]*10000

    def store(self, string):
        hash = self.calculate_hash_value(string)
        if hash < 0:
            return

        if self.lookup(string) > 0:
            return

        element = self.table[hash]
        if element is None:
            element = []
        element.append(string)
        self.table[hash] = element


    def lookup(self, string):
        hash = self.calculate_hash_value(string)
        if hash < 0:
            return -1

        elements = self.table[hash]
        if elements is None:
            return -1

        for element in elements:
            if element is string:
                return hash

        return -1

    def calculate_hash_value(self, string):
        i = len(string)
        if i < 2:
            return -1

        first = ord(string[0])
        second = ord(string[1])
        if not 65  <= first <= 90:
            return -1
        if not 65  <= second <= 90:
            return -1

        return (first * 100) + second



# Setup
hash_table = HashTable()

# Test calculate_hash_value
# Should be 8568
print hash_table.calculate_hash_value('UDACITY')

# Test lookup edge case
# Should be -1
print hash_table.lookup('UDACITY')

# Test store
hash_table.store('UDACITY')
# Should be 8568
print hash_table.lookup('UDACITY')

# Test store edge case
hash_table.store('UDACIOUS')
# Should be 8568
print hash_table.lookup('UDACIOUS')
