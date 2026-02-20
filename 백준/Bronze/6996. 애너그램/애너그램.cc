#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>


bool isAnagram(std::string a, std::string b) {
	std::sort(a.begin(), a.end());
	std::sort(b.begin(), b.end());
	return a == b;
}

void solve() {
	int n;
	std::cin >> n;
	
	while (n--) {
		std::string a, b;
		std::cin >> a >> b;
		
		if (isAnagram(a, b)) {
			std::cout << a << " & " << b << " are anagrams.\n";
		} else {
			std::cout << a << " & " << b << " are NOT anagrams.\n";
		}
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}