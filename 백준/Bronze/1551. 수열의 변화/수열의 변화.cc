#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_set>


std::vector <int> split(const std::string& str, char delimiter) {
	std::vector<int> tokens;
	std::string token;
	std::istringstream tokenStream(str);
	while (std::getline(tokenStream, token, delimiter)) {
		tokens.push_back(std::stoi(token));
	}
	return tokens;
}

std::vector<int> generateSequence(const std::vector<int>& arr) {
	std::vector<int> newArr;
	for (size_t i = 0; i < arr.size() - 1; ++i) {
		newArr.push_back(arr[i + 1] - arr[i]);
	}
	return newArr;
}

void solve() {

	int n, k;
	std::cin >> n >> k;

	std::string input;
	std::cin >> input;

	std::vector<int> arr = split(input, ',');

	while (k--) {
		arr = generateSequence(arr);
	}

	for (size_t i = 0; i < arr.size(); ++i) {
		std::cout << arr[i];
		if (i != arr.size() - 1) std::cout << ",";
	}
	
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}