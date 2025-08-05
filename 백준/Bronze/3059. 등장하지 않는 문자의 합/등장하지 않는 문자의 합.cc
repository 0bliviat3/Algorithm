#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

int get_ascii_sum() {
	int sum = 0;
	char c = 'A';
	while (c <= 'Z') {
		sum += c;
		c++;
	}
	return sum;
}

void solve() {

	
	int ascii_sum = get_ascii_sum();
	int n;
	std::cin >> n;
	std::cin.ignore();
	while (n--) {
		int sum = 0;
		bool alpabet[26] = { false };
		std::string s;
		std::getline(std::cin, s);
		for (char c : s) {
			if (alpabet[c - 'A']) continue;
			alpabet[c - 'A'] = true;
			sum += c;
		}
		std::cout << ascii_sum - sum << '\n';
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}