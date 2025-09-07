#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>

void solve() {

	int arr[26] = { 0, };
	int n;
	std::string str;
	std::cin >> n;
	std::cin.ignore();
	std::getline(std::cin, str);
	for (char c : str) {
		arr[c - 'a']++;
	}

	std::cout << *std::max_element(arr, arr + 26);

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}